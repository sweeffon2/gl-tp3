/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.authenticity.implementations;

import static java.nio.charset.StandardCharsets.UTF_8;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.emp.gl.messages.Authenticity;
import org.emp.gl.messages.IMessage;

/**
 *
 * @author younes
 */
public class SignatureRSA extends Authenticity{
    
    public SignatureRSA(IMessage message) {
        super(message);
        this.setMessage(this.innerMessage.getMessage());
    }


    @Override
    public void setMessage(String message) {
        KeyPair pair=null;
        String signature = "";
        
        try {
            pair = generateKeyPair();
        } catch (Exception ex) {
            Logger.getLogger(SignatureRSA.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            signature = sign(message, pair.getPrivate());
        } catch (Exception ex) {
            Logger.getLogger(SignatureRSA.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.innerMessage.setMessage(message+"\n signature : "+signature);
    }

    public static String sign(String plainText, PrivateKey privateKey) throws Exception {
        Signature privateSignature = Signature.getInstance("SHA256withRSA");
        privateSignature.initSign(privateKey);
        privateSignature.update(plainText.getBytes(UTF_8));

        byte[] signature = privateSignature.sign();

        return Base64.getEncoder().encodeToString(signature);
    }
    public static KeyPair generateKeyPair() throws Exception {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048, new SecureRandom());
        KeyPair pair = generator.generateKeyPair();

        return pair;
    }
    
}
