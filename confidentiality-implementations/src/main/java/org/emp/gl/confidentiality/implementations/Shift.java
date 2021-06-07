/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.confidentiality.implementations;

import org.emp.gl.messages.Confidentiality;
import org.emp.gl.messages.IMessage;

/**
 *
 * @author younes
 */
public class Shift extends Confidentiality{
    private int mShift;
    
    public Shift(IMessage message,int shift) {
        super(message);
        mShift=shift;
        this.setMessage(this.innerMessage.getMessage());
    }


    @Override
    public void setMessage(String message) {
        this.innerMessage.setMessage("\n shift : "+leftrotate(message,mShift) );
    }
    public String leftrotate(String str, int d)
    {
            String ans = str.substring(d) + str.substring(0, d);
            return ans;
    }
    
}
