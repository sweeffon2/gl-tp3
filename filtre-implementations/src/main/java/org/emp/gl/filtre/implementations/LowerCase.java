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
 * @author ali
 */
public class LowerCase  extends Filtre  {
    
    public LowerCase (IMessage message){
        super(message);
        this.setMessage(this.innerMessage.getMessage());
    }

    @Override
    public void setMessage(String message) {
        this.innerMessage.setMessage(message.toLowerCase());
    }
}
