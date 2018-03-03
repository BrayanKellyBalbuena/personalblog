/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

/**
 *
 * @author script-dark
 */
public enum LoginStatusEnum {
    SUCCESS(200),
    NOT_FOUND(404),
    FOUND(302),
    BAD_REQUEST(400),
    INTERNAL_ERROR(500);
   
    private final int value;
   
    private LoginStatusEnum(final int value){
        this.value = value;
    }
    
    public int getValue()
    {
        return value;
    }
}
