# messenger-send-api-client
Implementation of Facebook's [Messenger Platform: Send API](https://developers.facebook.com/docs/messenger-platform/send-api-reference)

## Basic usage
```kotlin
val pageAccessToken = "<YOUR_PAGE_ACCESS_TOKEN>"
val fbClient = FacebookMessengerSendApiClient(pageAccessToken)

// Get user profile
val userId = <USER_ID>
val user = fbClient.getUserProfile(userId)

// Set simple welcome message
val message = RequestMessageBuilder.withTextMessage("Hello, World")
                                   .buildRequestMessage()
val resp = fbClient.setWelcomeMessage(pageId, message)

var fbMessage = null

// Receipt example
fbMessage = RequestMessageBuilder
                .withStructuredMessageTemplateAttachment()
                .withReceiptTemplate()
                .addElement(
                        title = "Title 1",
                        subtitle = "subtitle 1",
                        quantity = 10,
                        price = 20.50,
                        currencyIsoCode = "EUR",
                        imageUrl = "http://img.jpg")
                .addElement(
                        title = "Title 2",
                        subtitle = "subtitle 2",
                        quantity = 10,
                        price = 20.50,
                        currencyIsoCode = "EUR",
                        imageUrl = "http://img2.jpg")
                .with(
                        recipientName = "John Smith",
                        orderNumber = Random().nextLong().toString(),
                        currencyIsoCode = "EUR",
                        paymentMethod = "MasterCard",
                        timestamp = Instant.now().epochSecond,
                        orderUrl = "http://order.url/xxxx",
                        orderSummary = OrderSummary(
                                subtotal = 55.55,
                                shippingCost = 10.1,
                                totalTax = 11,
                                totalCost = 65.65
                        ),
                        orderAddress = OrderAddress(
                                street1 = "My street line 1",
                                street2 = "My Street line 2",
                                city = "MyCity",
                                countryIsoCode = "US",
                                postalCode = "10019",
                                stateCode = "NY"
                        ),
                        adjustments = listOf(
                                PaymentAdjustment("New Customer Discount", 10),
                                PaymentAdjustment("Delivery Discount", 1)
                        )
                ).buildRequestMessage()

// Generic Template example
fbMessage = RequestMessageBuilder
        .withStructuredMessageTemplateAttachment()
        .withGenericTemplate()
        .addElement(
                title = "Generic Template Title",
                subtitle = "... And Subtitle",
                itemUrl = "http://item.url",
                imageUrl = "http://image.url.jpg")
        .addWebUrlButton("Btn Name", "http://btn.url")
        .addPostbackButton("Postback", "postback payload")
        .finishAddingButtons()
        .addLastElement(
                title = "Generic Template Title",
                subtitle = "... And Subtitle",
                itemUrl = "http://item.url",
                imageUrl = "http://img.jpg")
        .addWebUrlButton("btn title", "http://btn.url")
        .addPostbackButton("Postback", MyCustomePayloadObject())
        .finishAddingButtons()
        .buildRequestMessage()

// Button Template example
fbMessage = RequestMessageBuilder
        .withStructuredMessageTemplateAttachment()
        .withButtonTemplate()
        .addWebUrlButton("Button Name", "http://button.url")
        .addPostbackButton("PostBack", "hello world")
        .withText("Testing buttons")
        .buildRequestMessage()
        
        
// send request example
val receiptFbRequest = MessengerRequestBuilder.byRecipientId(<RECIPIENT_ID>, fbMessage)
fbClient.sendRequest(receiptFbRequest)
```