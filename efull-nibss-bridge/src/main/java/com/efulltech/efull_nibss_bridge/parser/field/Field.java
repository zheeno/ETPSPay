/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efulltech.efull_nibss_bridge.parser.field;

/**
 *
 * @author shemistone
 */
public interface Field {

    void setValue(String value);

    String getValue();

    String encode();

    int decode(String head);

    void setEncodedValue(String encodedValue);

    String getEncodedValue();
    
}
