package com.example.billlingservice.grpc;

import billing.BillingResponse;
import billing.BillingServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GrpcService
public class BillingGrpcService extends BillingServiceGrpc.BillingServiceImplBase {
    private static final Logger log = LoggerFactory.getLogger(BillingGrpcService.class);

    @Override
    public void createBillingaccount(billing.BillingRequest billingRequest,
                                     StreamObserver<billing.BillingResponse> responsObserver) {
        log.info("creatingBillingAccount request received {} ",billingRequest.toString());

        //BL
        BillingResponse response = BillingResponse.newBuilder()
                .setAccountId("12333").setStatus("Active").build();
        responsObserver.onNext(response);


        responsObserver.onCompleted();
    }


}
