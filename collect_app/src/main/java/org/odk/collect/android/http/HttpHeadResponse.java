/*
 * Copyright 2018 Nafundi
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

package org.odk.collect.android.http;

import static java.net.HttpURLConnection.HTTP_NO_CONTENT;
import static javax.net.ssl.HttpsURLConnection.HTTP_MULT_CHOICE;
import static javax.net.ssl.HttpsURLConnection.HTTP_OK;
import static org.opendatakit.httpclientandroidlib.HttpStatus.SC_UNAUTHORIZED;

import android.support.annotation.NonNull;
import java.util.Map;

public class HttpHeadResponse {

    private final Map<String, String> headers;
    private final int statusCode;

    public HttpHeadResponse(@NonNull Map<String, String> headers, int statusCode) {
        this.headers = headers;
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public boolean isUnauthorized() {
        return statusCode == SC_UNAUTHORIZED;
    }

    public boolean isNoContent() {
        return statusCode == HTTP_NO_CONTENT;
    }

    /**
     * Returns true if the status code is in the range of what's considered a
     * successful response (2xx). False otherwise.
     */
    public boolean isSuccess() {
        return statusCode >= HTTP_OK && statusCode < HTTP_MULT_CHOICE;
    }
}
