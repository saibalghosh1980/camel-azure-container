package com.oup.camelazurecontainer.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AzureBlobRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        // TODO Auto-generated method stub
        from("file:///Users/kumarghs/Documents/DEVELOPMENT/camel-azure-container/file?move=.done")
        .log(LoggingLevel.INFO,log,"${body}")
        .to("azure-storage-blob:skgsa/saibal?blobName=dev/hello.txt&fileDir=dev&operation=uploadBlockBlob");
    }
    
}
