/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.messages;

/**
 *
 * @author younes
 */
public abstract class Decor implements IMessage {
    protected IMessage innerMessage;

    public Decor(IMessage message) {
        innerMessage=message;
    }
    
    public String getTitle() {
        return innerMessage.getTitle();
    }

    
    public String getSender() {
          return innerMessage.getSender();
    }

    
    public String getMessage() {
        return innerMessage.getMessage();
    }

    
    public void setTitle(String title) {
          innerMessage.setTitle(title);
    }

    
    public void setSender(String sender) {
          innerMessage.setSender(sender);
    }

    
    public void setMessage(String message) {
          innerMessage.setMessage(message);
    }
    @Override
    public String toString() {
        return innerMessage.toString();
    }
    
}
