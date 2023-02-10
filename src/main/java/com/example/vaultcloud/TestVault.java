package com.example.vaultcloud;

import com.example.vaultcloud.model.Secret;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.core.VaultKeyValueOperations;
import org.springframework.vault.core.VaultKeyValueOperationsSupport;
import org.springframework.vault.core.VaultTemplate;

import java.net.URI;
import java.util.Date;


public class TestVault {

    public static void main(String[] args) {
        VaultTemplate vaultTemplate = new VaultTemplate(VaultEndpoint.from(URI.create("http://localhost:8200")),
                new TokenAuthentication("hvs.7GB7xtda9B6w0sKQSPJgHmhC"));

        VaultKeyValueOperations keyValueOperations = vaultTemplate.opsForKeyValue("rotate",
                VaultKeyValueOperationsSupport.KeyValueBackend.KV_2);

        Secret secret = new Secret();
        secret.setPassword(Long.valueOf(new Date().toInstant().toEpochMilli()).toString());
        secret.setUserName("Mary");

        keyValueOperations.put("test", secret);
        System.out.println(keyValueOperations.get("test", Secret.class).isRenewable());

    }

//    public static void main(String[] args) {
//        VaultTemplate vaultTemplate = new VaultTemplate(VaultEndpoint.from(URI.create("http://secman-dzo.solution.sbt:8200")),
//                new TokenAuthentication("s.utSuX495JyUai2RZRctC9OUp"));
//
//        VaultKeyValueOperations keyValueOperations = vaultTemplate.opsForKeyValue("DEV/SEGR/FS/KV",
//                VaultKeyValueOperationsSupport.KeyValueBackend.KV_1);
//
//        Secret secret = new Secret();
//        secret.setPassword(Long.valueOf(new Date().toInstant().toEpochMilli()).toString());
//        secret.setUserName("Mary");
//
//        keyValueOperations.put("kafka", secret);
//        System.out.println(keyValueOperations.get("kafka").isRenewable());
//
//    }
}
