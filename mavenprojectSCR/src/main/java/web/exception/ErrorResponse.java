/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.exception;
import lombok.Data;
/**
 *
 * @author andrewhinton
 */
    @Data
class ErrorResponse {
    private String error;
    private String message;

    /**
     * Constructor for creating an error response.
     *
     * @param error   the error title
     * @param message the error message
     */
    public ErrorResponse(String error, String message) {
        this.error = error;
        this.message = message;
    }
}