/*
 * Copyright © YOLANDA. All Rights Reserved
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yolanda.nohttp;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * JsonArray is returned by the server data, using the request object
 * </br>
 * Created in Jan 19, 2016 3:32:28 PM
 *
 * @author YOLANDA;
 */
public class JsonArrayRequest extends RestRequestor<JSONArray> {

    public JsonArrayRequest(String url) {
        this(url, RequestMethod.POST);
    }

    public JsonArrayRequest(String url, RequestMethod requestMethod) {
        super(url, requestMethod);
    }

    @Override
    public String getAccept() {
        return JsonObjectRequest.ACCEPT;
    }

    @Override
    public JSONArray parseResponse(String url, Headers responseHeaders, byte[] responseBody) {
        String josnStr = StringRequest.parseResponseString(url, responseHeaders, responseBody);
        try {
            return new JSONArray(josnStr);
        } catch (Exception e) {
            try {
                return new JSONArray("[]");
            } catch (JSONException exception) {
            }
        }
        return null;
    }

}
