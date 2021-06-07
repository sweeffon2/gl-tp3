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
public abstract class Authenticity extends Decor{
    
    public Authenticity(IMessage message) {
        super(message);
    }
    
}
