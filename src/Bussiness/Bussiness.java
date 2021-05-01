/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussiness;

import Data.ClassData;

/**
 *
 * @author ADMIN
 */
public class Bussiness {
        ClassData DB;
        String SQL;
        String Table;
        String ID;
    public Bussiness(){ 
        }
    public Bussiness(ClassData db, String table, String ID){
        this.DB=db;
        this.Table=table;
        this.ID=ID;
    }
    public Bussiness(ClassData db, String table){
        this.DB=db;
        this.Table=table;
    }
}
