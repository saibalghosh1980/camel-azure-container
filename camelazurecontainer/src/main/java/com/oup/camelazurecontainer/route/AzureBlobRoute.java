package com.oup.camelazurecontainer.route;

import com.microsoft.azure.storage.StorageCredentialsAccountAndKey;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AzureBlobRoute extends RouteBuilder {

    @Bean("credentials")
    public StorageCredentialsAccountAndKey getCredential(){
        StorageCredentialsAccountAndKey storageCredentialsAccountAndKey=new StorageCredentialsAccountAndKey("XXXXX","YYYYY");
        return storageCredentialsAccountAndKey;

    }

    @Override
    public void configure() throws Exception {
        // TODO Auto-generated method stub
        from("file:////home/wolverine/camel-azure-container?move=.done")
        .log(LoggingLevel.INFO,log,"${body}")
        .to("azure-blob://STORAGE_ACC_NAME/CONTAINER_NAME/dev/hello.txt?useFlatListing=false&operation=updateBlockBlob&credentials=#credentials");
    }
    
}
