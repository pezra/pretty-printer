/*
  (c) Copyright 2007 Hewlett-Packard Development Company, LP
  [See end of file]
  $Id: AbsRewindableInputStreamOrReader.java 1121 2007-04-11 15:02:58Z jeremy_carroll $
*/
package com.hp.hpl.jena.grddl.impl;

import java.io.IOException;

/**
 * RewindableInputStream
 * @author Jeremy J. Carroll
 */
abstract public class AbsRewindableInputStreamOrReader extends Rewindable {

	public AbsRewindableInputStreamOrReader( String base) {
		super(checkBase(base));
		
	}

	private static String checkBase(String base) {
		if (base==null || base.equals(""))
			throw new UnsupportedOperationException("The GRDDL reader requires a base URI to be specified.");
		return base;
	}

	@Override
	void close() throws IOException {
		
	}

	@Override
	String encoding() {
		return null;
	}

	@Override
	String mimetype() {
		return null;
	}

	
	
	

}


/*
    (c) Copyright 2007 Hewlett-Packard Development Company, LP
    All rights reserved.

    Redistribution and use in source and binary forms, with or without
    modification, are permitted provided that the following conditions
    are met:

    1. Redistributions of source code must retain the above copyright
       notice, this list of conditions and the following disclaimer.

    2. Redistributions in binary form must reproduce the above copyright
       notice, this list of conditions and the following disclaimer in the
       documentation and/or other materials provided with the distribution.

    3. The name of the author may not be used to endorse or promote products
       derived from this software without specific prior written permission.

    THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
    IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
    OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
    IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
    INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
    NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
    DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
    THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
    (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
    THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/