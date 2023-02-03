package com.techelevator;

/**
 * Crypto encrypts strings using a substitution cypher. In a substitution
 * cypher, every letter is replaced with a different letter.
 *
 * For this exercise, use the following substitution cypher:
 *
 *   Letter -> Encrypts To
 *     A    ->    N
 *     B    ->    J
 *     C    ->    F
 *     D    ->    Q
 *     E    ->    A
 *     F    ->    P
 *     G    ->    S
 *     H    ->    R
 *     I    ->    X
 *     J    ->    G
 *     K    ->    D
 *     L    ->    O
 *     M    ->    T
 *     N    ->    E
 *     O    ->    U
 *     P    ->    H
 *     Q    ->    M
 *     R    ->    V
 *     S    ->    B
 *     T    ->    C
 *     U    ->    W
 *     V    ->    K
 *     W    ->    Z
 *     X    ->    I
 *     Y    ->    L
 *     Z    ->    Y
 */
public class Crypto {

    /**
     * Encrypts and returns "strToEncrypt" using the substitution cypher above
     *
     * @param strToEncrypt The String to encrypt
     * @return The encrypted String
     */
    public String encrypt(String strToEncrypt) {
        String []alphabet = new String [26];
        alphabet[0]="A";
        alphabet[1]="B";
        alphabet[2]="C";
        alphabet[3]="D";
        alphabet[4]="E";
        alphabet[5]="F";
        alphabet[6]="G";
        alphabet[7]="H";
        alphabet[8]="I";
        alphabet[9]="J";
        alphabet[10]="K";
        alphabet[11]="L";
        alphabet[12]="M";
        alphabet[13]="N";
        alphabet[14]="O";
        alphabet[15]="P";
        alphabet[16]="Q";
        alphabet[17]="R";
        alphabet[18]="S";
        alphabet[19]="T";
        alphabet[20]="U";
        alphabet[21]="V";
        alphabet[22]="W";
        alphabet[23]="X";
        alphabet[24]="Y";
        alphabet[25]="Z";

        String[] encryptedAlphabet= new String[26];
        //NJFQAPSRXGDOTEUHMVBCWKZILY
        encryptedAlphabet[0]= "N";
        encryptedAlphabet[1]="J";
        encryptedAlphabet[2]="F";
        encryptedAlphabet[3]="Q";
        encryptedAlphabet[4]="A";
        encryptedAlphabet[5]="P";
        encryptedAlphabet[6]="S";
        encryptedAlphabet[7]="R";
        encryptedAlphabet[8]="X";
        encryptedAlphabet[9]="G";
        encryptedAlphabet[10]="D";
        encryptedAlphabet[11]="O";
        encryptedAlphabet[12]="T";
        encryptedAlphabet[13]="E";
        encryptedAlphabet[14]="U";
        encryptedAlphabet[15]="H";
        encryptedAlphabet[16]="M";
        encryptedAlphabet[17]="V";
        encryptedAlphabet[18]="B";
        encryptedAlphabet[19]="C";
        encryptedAlphabet[20]="W";
        encryptedAlphabet[21]="K";
        encryptedAlphabet[22]="Z";
        encryptedAlphabet[23]="I";
        encryptedAlphabet[24]="L";
        encryptedAlphabet[25]="Y";

        for(int i=0; i<strToEncrypt.length();i++){
            if(strToEncrypt.charAt([i])){

            }


        }


    }

    /**
     * Decrypts and returns "strToDecrypt" using the cypher above
     *
     * @param strToDecrypt The String to decrypt
     * @return The decrypted String
     */
    public String decrypt(String strToDecrypt) {
        return null;
    }
}


