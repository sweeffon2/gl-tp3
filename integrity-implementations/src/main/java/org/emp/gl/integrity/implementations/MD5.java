/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.integrity.implementations;

import static java.nio.charset.StandardCharsets.UTF_8;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.emp.gl.messages.IMessage;
import org.emp.gl.messages.Integrity;

/**
 *
 * @author younes
 */
public class MD5 extends Integrity {
    
    public MD5(IMessage message) {
        super(message);
        this.setMessage(this.innerMessage.getMessage());
    }


    @Override
    public void setMessage(String message) {
        byte[] md5InBytes = this.digest(message.getBytes(UTF_8));
        this.innerMessage.setMessage(message+" \n MD5 : "+bytesToHex(md5InBytes));
    }


    private static byte[] digest(byte[] input) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
        byte[] result = md.digest(input);
        return result;
    }
}
