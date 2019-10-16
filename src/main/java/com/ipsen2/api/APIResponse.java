package com.ipsen2.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ipsen2.api.services.JacksonService;
import io.dropwizard.jackson.Jackson;

import java.util.ArrayList;
import java.util.Arrays;

/*

    ERROR CODES:

    code    message
    0       OK
    1       Not implemented

    100     Server error
    101     Server error: JsonProcessingException in .serialize()

 */

/** API response that will be serialized to JSON and sent to the client.
 *
 * @author Tim W, TimvHal
 * @version 14/10/2019
 */
public class APIResponse {

    @JsonProperty("success")
    public boolean success;
    @JsonProperty("code")
    public int code;
    @JsonProperty("message")
    public String message;
    @JsonProperty("data")
    public ArrayList<Object> data;

    /** Create API response.
     * The 'success' field will be set to <b>true</b>.
     *
     * @param obj The object to serialize.
     *
     * @author Tim W, TimvHal
     * @version 14/10/2019
     */
    public APIResponse(Object obj) {

        this.success = true;
        this.code = 0;
        this.message = "OK";
        this.data = new ArrayList<>();
        this.data.add(obj);

    }

    /** Create API response.
     * The 'success' field will be set to <b>true</b>.
     *
     * @param data The objects to serialize.
     *
     * @author Tim W, TimvHal
     * @version 14/10/2019
     */
    public APIResponse(ArrayList<Object> data) {

        this.success = true;
        this.code = 0;
        this.message = "OK";
        this.data = data;

    }

    /** Create error response.
     * The 'success' field will be set to <b>false</b>.
     *
     * @param response is String-object split into an error code and message.
     *
     * @author Tim W, TimvHal
     * @version 14/10/2019
     */
    public APIResponse(String response) {
        ArrayList<String> responseSplit = new ArrayList<>(Arrays.asList(response.split(" ")));
        int errorCode = Integer.parseInt(responseSplit.get(0));
        responseSplit.remove(0);
        String errorMessage = "";
        for(String messagePart : responseSplit) {
                errorMessage += messagePart;
        }

        this.success = false;
        this.code = errorCode;
        this.message = errorMessage;
        this.data = new ArrayList<>();

    }

    /** Serialize response to JSON string.
     *
     * @return The JSON string based on the response object.
     *
     * @author Tim W, TimvHal
     * @version 16/10/2019
     */
    public String serialize() {
        return JacksonService.writeValueAsString(this.data);
    }
}
