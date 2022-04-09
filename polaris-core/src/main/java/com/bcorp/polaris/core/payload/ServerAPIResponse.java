package com.bcorp.polaris.core.payload;

public interface ServerAPIResponse
{
    ServerResponse getError();

    void setError(ServerResponse serverResponse);
}
