/*
  (c) Copyright 2007 Hewlett-Packard Development Company, LP
  [See end of file]
  $Id: GRDDLSecurityException.java 2242 2007-09-24 15:35:19Z jeremy_carroll $
*/
package com.hp.hpl.jena.grddl;

import com.hp.hpl.jena.shared.JenaException;


/**
 * GRDDLSecurityException is thrown when a potentially
 * malicious operation is attempted.
 * It is advised to treat this exception with specific code,
 * and to alert a human user to the potential attack.
 * @author Jeremy J. Carroll
 */
@SuppressWarnings("serial")
public class GRDDLSecurityException extends JenaException {

	public GRDDLSecurityException(Exception e) {
		super(e);
	}

	public GRDDLSecurityException(String string) {
		super(string);
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