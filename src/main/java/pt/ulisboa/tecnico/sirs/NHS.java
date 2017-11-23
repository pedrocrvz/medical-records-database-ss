package pt.ulisboa.tecnico.sirs;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.security.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NHS extends Entity {

    private class Server extends UnicastRemoteObject implements NHSInterface {
        Server() throws RemoteException {
            super(0); //TODO TLS
        }
    }

    public NHS(KeyStore ks, String keyAlias, String ksPassword)
            throws UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, RemoteException,
            MalformedURLException {
        super(ks, keyAlias, ksPassword);
        Naming.rebind("//localhost/NHS", new Server());
    }
}
