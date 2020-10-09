package sns

import grails.gorm.transactions.Transactional

import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.sns.SnsClient
import software.amazon.awssdk.services.sns.model.SubscribeRequest
import software.amazon.awssdk.services.sns.model.SnsException
import software.amazon.awssdk.services.sns.model.PublishRequest

@Transactional
class SnsService {

    def serviceMethod() {

    }

    def subscribe() {
        SnsClient snsClient = SnsClient.builder()
                .region(Region.AP_NORTHEAST_1)
                .build()
        try {
            SubscribeRequest request = SubscribeRequest.builder()
                    .topicArn("ここにトピックのARNを入力")
                    .endpoint("ここに通知先に設定したいメールアドレスを入力")
                    .protocol("email")
                    .build()
            snsClient.subscribe(request)
        } catch (SnsException e) {
            println(e)
        }
    }

    def sendMessage() {
        SnsClient snsClient = SnsClient.builder()
                .region(Region.AP_NORTHEAST_1)
                .build()
        try {
            PublishRequest request = PublishRequest.builder()
                    .message("ここに送信したいメッセージを入力")
                    .topicArn("ここにトピックのARNを入力")
                    .build()
            snsClient.publish(request)
        } catch (SnsException e) {
            println(e)
        }
    }
}
