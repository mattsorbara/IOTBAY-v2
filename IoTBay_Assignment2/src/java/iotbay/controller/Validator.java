/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iotbay.controller;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;

/**
 *
 * @author matthewsorbara
 */
public class Validator {
    
    private String emailPattern = "([a-zA-Z0-0]+)(([._-])([a-zA-Z0-9]+))*(@)([a-z]+)(.)([a-z]{3})((([.])[a-z]{0,2}).*)";
    private String namePattern = "([A-Z][a-z]+[\\z])+[A-Z][a-z]*";
    private String passwordPattern = "([a-z]{4,})([0,9]*)";
    
    
}
