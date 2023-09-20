package com.example.restapi.utils;

import org.springframework.stereotype.Component;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Component
public class RSAKeyProperties {

    private RSAPublicKey publicKey;
    private RSAPrivateKey privateKey;

    public RSAKeyProperties() {
        KeyPair pair = KeyGeneratorUtility.generateRsaKey();
        this.publicKey = (RSAPublicKey) pair.getPublic();
        this.privateKey = (RSAPrivateKey) pair.getPrivate();
    }

    public RSAPublicKey getPublicKey() {
        return publicKey;
    }

    public RSAKeyProperties setPublicKey(RSAPublicKey publicKey) {
        this.publicKey = publicKey;
        return this;
    }

    public RSAPrivateKey getPrivateKey() {
        return privateKey;
    }

    public RSAKeyProperties setPrivateKey(RSAPrivateKey privateKey) {
        this.privateKey = privateKey;
        return this;
    }
}
