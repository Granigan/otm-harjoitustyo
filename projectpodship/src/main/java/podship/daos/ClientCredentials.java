/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package podship.daos;

/**
 *
 * @author tgtapio
 */
public class ClientCredentials {

    static final String API_KEY
            = "AIzaSyBQJlsAOCms7A0FAamp6nHOrPuWsVvIY_M"
            + ClientCredentials.class;

    static void errorIfNotSpecified() {
        if (API_KEY.startsWith("Enter ")) {
            System.err.println(API_KEY);
            System.exit(1);
        }
    }
}

