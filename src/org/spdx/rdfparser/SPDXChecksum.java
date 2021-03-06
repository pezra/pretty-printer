/**
 * Copyright (c) 2011 Source Auditor Inc.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
*/
package org.spdx.rdfparser;

import com.hp.hpl.jena.graph.Node;
import com.hp.hpl.jena.graph.Triple;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;

/**
 * SPDX Checksum class for packages and files
 * @author Gary O'Neall
 *
 */
public class SPDXChecksum {

	// Supported algorithms
	
	public static final String ALGORITHM_SHA1 = "SHA1";
	private String algorithm;
	private String value;
	private Model model;
	private Node checksumNode;
	private Resource checksumResource;
	
	public SPDXChecksum(String algorithm, String value) {
		this.algorithm = algorithm;
		this.value = value;
	}
	
	public SPDXChecksum(Model spdxModel, Node checksumNode) throws InvalidSPDXAnalysisException {
		this.model = spdxModel;
		this.checksumNode = checksumNode;
		if (checksumNode.isBlank()) {
			checksumResource = model.createResource(checksumNode.getBlankNodeId());
		} else if (checksumNode.isURI()) {
			checksumResource = model.createResource(checksumNode.getURI());
		} else {
			throw(new InvalidSPDXAnalysisException("Checksum node can not be a literal"));
		}
		// Algorithm
		Node p = spdxModel.getProperty(SPDXAnalysis.SPDX_NAMESPACE, SPDXAnalysis.PROP_CHECKSUM_ALGORITHM).asNode();
		Triple m = Triple.createMatch(checksumNode, p, null);
		ExtendedIterator<Triple> tripleIter = spdxModel.getGraph().find(m);	
		while (tripleIter.hasNext()) {
			Triple t = tripleIter.next();
			this.algorithm = t.getObject().toString(false);
		}
		
		// value
		p = spdxModel.getProperty(SPDXAnalysis.SPDX_NAMESPACE, SPDXAnalysis.PROP_CHECKSUM_VALUE).asNode();
		m = Triple.createMatch(checksumNode, p, null);
		tripleIter = spdxModel.getGraph().find(m);	
		while (tripleIter.hasNext()) {
			Triple t = tripleIter.next();
			this.value = t.getObject().toString(false);
		}
	}

	/**
	 * @return the algorithm
	 */
	public String getAlgorithm() {
		return algorithm;
	}

	/**
	 * @param algorithm the algorithm to set
	 */
	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
		if (this.model != null && this.checksumNode != null) {
			// delete any previous algorithm
			Property p = model.getProperty(SPDXAnalysis.SPDX_NAMESPACE, SPDXAnalysis.PROP_CHECKSUM_ALGORITHM);
			model.removeAll(checksumResource, p, null);
			// add the property
			p = model.createProperty(SPDXAnalysis.SPDX_NAMESPACE, SPDXAnalysis.PROP_CHECKSUM_ALGORITHM);
			checksumResource.addProperty(p, algorithm);
		}
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
		if (this.model != null && this.checksumNode != null) {
			// delete any previous value
			Property p = model.getProperty(SPDXAnalysis.SPDX_NAMESPACE, SPDXAnalysis.PROP_CHECKSUM_VALUE);
			model.removeAll(checksumResource, p, null);
			// add the property
			p = model.createProperty(SPDXAnalysis.SPDX_NAMESPACE, SPDXAnalysis.PROP_CHECKSUM_VALUE);
			checksumResource.addProperty(p, value);
		}
	}
	
	public Resource createResource(Model model) {
		this.model = model;
		Resource type = model.createResource(SPDXAnalysis.SPDX_NAMESPACE +
				SPDXAnalysis.CLASS_SPDX_CHECKSUM);
		Resource r = model.createResource(type);
		if (algorithm != null) {
			Property algProperty = model.createProperty(SPDXAnalysis.SPDX_NAMESPACE, 
					SPDXAnalysis.PROP_CHECKSUM_ALGORITHM);
			r.addProperty(algProperty, this.algorithm);
		}
		if (this.value != null) {
			Property valueProperty = model.createProperty(SPDXAnalysis.SPDX_NAMESPACE, SPDXAnalysis.PROP_CHECKSUM_VALUE);
			r.addProperty(valueProperty, this.value);
		}
		this.checksumNode = r.asNode();
		this.checksumResource = r;
		return r;
	}

}
