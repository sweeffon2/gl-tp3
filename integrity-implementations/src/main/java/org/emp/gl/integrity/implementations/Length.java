/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.integrity.implementations;

import org.emp.gl.messages.IMessage;
import org.emp.gl.messages.Integrity;

/**
 *
 * @author younes
 */
public class Length extends Integrity {
    
    public Length(IMessage message) {
        super(message);
        this.setMessage(this.innerMessage.getMessage());
    }


    @Override
    public void setMessage(String message) {
        this.innerMessage.setMessage(message+"\n length : "+message.length());
    }
}
