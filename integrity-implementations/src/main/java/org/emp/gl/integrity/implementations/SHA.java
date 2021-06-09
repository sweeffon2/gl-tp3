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
public class SHA extends Integrity {
    
    public SHA(IMessage message) {
        super(message);
        this.setMessage(this.innerMessage.getMessage());
    }

    @Override
    public void setMessage(String message) {
        byte[] shaInBytes = this.digest(message.getBytes(UTF_8), "SHA-224");
        this.innerMessage.setMessage(message+" \n SHA : "+bytesToHex(shaInBytes));
    }
    public static byte[] digest(byte[] input, String algorithm) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
        byte[] result = md.digest(input);
        return result;
    }
    
}
