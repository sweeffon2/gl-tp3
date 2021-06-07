/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.filtre.implementations;

import org.emp.gl.messages.Filtre;
import org.emp.gl.messages.IMessage;

/**
 *
 * @author younes
 */
public class NoSpace extends Filtre  {
    
    public NoSpace(IMessage message) {
        super(message);
        this.setMessage(this.innerMessage.getMessage());
    }

    @Override
    public void setMessage(String message) {
        this.innerMessage.setMessage(message.replaceAll(" ", ""));
    }
}
