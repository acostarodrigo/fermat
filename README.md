bitDubai
========

The objective of the bitDubai project is to develop the technology found to be necessary to achieve world-wide adoption of crypto currencies as fast as possible.

In order to accomplish this goal a prioritized list of the problems/barriers that are preventing mass adoption has been compiled and a solution has been proposed to each of these problems bearing in mind that each solution must fit into the architecture of one single system aimed to simultaneously address all problems identified.

As of today two interconnected platforms constitute the system: a Crypto Wallet Platform and a Crypto Banking Platform.

The current status of the project is moving towards a non working prototype of the wallet com.bitdubai.platform. The architecture of the system has already been established. The first version of the wallet com.bitdubai.platform featuring a Kids wallet is scheduled to be available to the general public by March 2015.


# Crypto Wallet Platform

Is a P2P com.bitdubai.platform with an open architecture that allows highly segmented wallets to be easily created on top of it by any developer using assets provided by other third parties. These in turn can be re-branded by marketeers and distributed by brands. An inbuilt licensing system guarantees each party that the use license of their contributions will be enforced by the com.bitdubai.platform.


# Crypto Banking Platform

Is an extension of the core banking systems banks usually have. It allows traditional banks to create "crypto products" in their own systems adding all the missing components necessary to make that happen.  



# Problems & Solutions

The problems listed here are in order of importance. If you don't agree with the priorization, description of either the problem or the solution, or you belive there are other problems not considered here submit a pull request with your suggestions or mail them to contribution@bitdubai.com .

## Problem #1
### People don't want to lose money resulting from volatility

#### Description:

Regular people are reluctant to buy and spend bitcoins because they don't want to spend them knowing that they lose on the transaction and neither do they want to keep track of the prices when buying or spending them.

#### Example: 

John Doe bought some bitcoins when the prices were $154, $543, $1243. He also spent some when prices were $355, $731, etc. Owing to this volatility at one point he could not ascertain that by continuing spending his bitcoins he would not lose money. He was also discouraged from buying even more at different prices and from doing the tracking necessary to ensure he would not lose money. In short, he has given up using bitcoin and is waiting for the price to increase so that it is high enough for him to be able to spend the ones he still has without the inconvenience of having to calculate when it is safe to spend. 

#### Solution:

##### Turn the volatility problem into an advantage

* Automate all the management needed to know when it is safe to spend  bitcoins or any other crypto currency. This allows regular people to buy and spend bitcoins, whenever they need, confident that they never lose money. 

* Moreover each time a user spends within the limits of the available balance calculated by the com.bitdubai.platform they will profit from the exchange rate. This profit can be interpreted as a discount produced by the wallet technology and serves as a real life incentive to use crypto currency over fiat at any time.

##### Associated Concepts:

* Available Balance
* Wallet Discount

## Problem #2
### Lack of local ecosystems

#### Description:

Bringing bitcoins to a local ecosystem is expensive. You usually pay extra money for bringing them in. 

Then when you spend it at a local shop the payment processor takes those bitcoins again out of the local ecosystem forcing local users to bring them back from abroad perpetuating the difficulty of getting coins for regular people.

Merchants prefer not to hold bitcoins because of the risk of losing money when cashing them out. 

Merchants are facing exactly the same volatility problem as consumers but amplified as the transactions happen much more often when compared to a regular user. Payment processors solve the problem for them at the expense of depriving local ecosystems from crypto currency.

#### Example: 

Budapest is a capital city of a European country. It is not only difficult to find a place where you can buy bitcoins (there is only one BTM) but you have to pay 5-10% more than at international marketplaces. If I go and spend it in one of the few local shops that accept them the payment processor makes them leave the country again. The ironic part is that the shop takes my bitcoins at the market price charged on an international market thereby automatically producing me a loss of 5 to 10%. 

#### Solution:

* By automating the management for local merchants necessary for them to know when it is safe to resell the bitcoins collected and solving their volatility problem it provides an alternative to a payment processor. Thus merchants can start holding crypto currency and act as refill points for local users. This enables local economies to keep their crypto currency within the ecosystem also allowing local users to have access to bitcoins without the need to pay extra fees to buy them from abroad.

* Create a geo fenced P2P network within the wallet com.bitdubai.platform to allow local users to easily track nearby shops and places where they can spend their coins, refill their wallets or cash out. Through this P2P network shops can advertise their individual products to nearby users. Not only can consumers buy, reserve and review products, but they can also communicate with the shop.

##### Associated Concepts:

* Local Shop
* Refill Point
* Cash Out Point
* Geo Fenced P2P network

##### Associated Functionality:

* Create and manage a Local Shop within the system.
* Create and manage a Refill Point within the system.
* Create and manage a Cash Out Point within the system.
* Locate nearby Shops.
* Locate nearby Refill Points.
* Locate nearby Cash Out Points.

##### Proposed Functionality:

* B2C paid advertisements.



## Problem #3
### Lack of wallet segmentation

#### Description:

When music went digital cassette tapes disappeared. With the digitalization of image film cameras vanished. The technology that permits the digitalization of money has already been invented, consequently paper money and metal coins are bound to disappear soon. Some countries are already considering issuing their currency using this technology. 

Digitalization of money will inevitably bring about with the entire population using digital wallets. People from all walks of life have different needs and demands which should be reflected in their wallet. The user interface, the functionality available and the way it is accessed should be adapted in a way that best fits the age, gender, cultural background, level of education, social status, etc. of the given user.

The way a Chinese country man thinks and interprets the operations of a wallet is inherently totally different from the way a person from the UK, Argentina, North Korea, Lebanon, Cuba, Nigeria, etc. does. What an accountant could be interested in doing with and seeing in his wallet is not the same what a psychologist, a lawyer or an engineer would be. 

A kid's wallet can not look the same as his teenage brother's or his father's. It is not difficult to visualize that in the future there will be thousands of highly segmented wallets for every single niche imaginable. 

However, on the other hand the core algorithms and mathematics inside those wallets are universal. 

Currently wallet providers can barely identify the different segments of the potential user population and they target almost exclusively the tech-savvy segment even if in their minds they are delivering a user friendly product to everyday people too. 

The problem to be solved is how we can save everybody a few years and evolve from where we are now to that future without having to replicate the same universal technology again and again for every single segmented wallet. 

#### Solution:

* Separate all universal algorithms and mathematics needed to manage crypto wallets and incorporate all that functionality in the crypto wallet com.bitdubai.platform. All the segment-specific functionality including the user interface should be outside the com.bitdubai.platform. In this way anyone can quickly and easily create segmented wallets without the need to replicate the universal rules over and over again.

* Open source each segmented wallet so that anyone can use it as a basis for other segments/sub-segments or for an alternative implementation of the same segment.

* Incorporate a licensing system into the com.bitdubai.platform, which allows third party developers to claim a use license for their wallets and make the com.bitdubai.platform guarantee that users will pay according to this license. Other developers can in turn fork any existing segmented wallet with the intention of further specializing it and at the same time also adding their own license which the com.bitdubai.platform is going to enforce automatically together with the use licenses of the original authors.

* The same licensing rules apply to graphic designers who provide assets and resource packages to be used in wallets within the com.bitdubai.platform.

* Any of the wallets available can be taken and re-branded by marketing companies in order to be offered to their own customers as an evolution to current loyalty programs. They or their customers can add more license requirements to the already existing license structure of the original wallet.

* A recognized local brand can take a re-branded wallet and market it to both local end users and local merchants coordinating the supply and demand and using their own financial means to do so.

* Include in the wallet com.bitdubai.platform a wallet store from where end users can download any of the wallets available.

* Developers, marketeers and brands can publish their wallets in the wallet store. 

##### Associated Concepts:

* Wallet Store
* Wallet Manager
* Wallet Factory
* Segmented Wallet
* Wallet Runtime
* Licensing Layer

##### Associated Functionality:

* Run a third party wallet on top of the wallet com.bitdubai.platform
* Allow end users to download any wallet available in the wallet store



## Problem #4
### Banks not stepping in

#### Description:

* Traditional banks can see the disruption coming. They see that crypto networks are a disruptive technology opening up a huge opportunity for those who can take it quickly enough and posing great threat to those who can't. They lack the agility to come up with a solution by themselves and their traditional com.bitdubai.platform providers aren't helping. They need to move/react quickly but at the same time should have the agility to adapt to this rapidly evolving landscape.

* The only way they have recognized so far is to connect to and rely upon a set of startups in order to be able to run a crypto bank. They understand the risk of dealing with companies that can go bankrupt overnight or that don't fully comply with regulations. They are also facing the fact that converting them into crypto banks is not the core business of any of these startups. 

* Integrating each of their systems one by one into this new technology appears to be a huge and resource intensive project.

* Banks have huge financial power to market crypto products to their current customer base, constituting half of the adult population of the world, but they are not doing it in part because the don't have the technology needed to turn a bank into a crypto bank. 


#### Solution:

* Complement the IT infrastructure traditional banks already have allowing them to reuse most of it seamlessly. Enable banks to create new products such as bitcoin accounts for their costumers irrespective of the core banking system they currently have. Enable customers to freely transfer FROM and TO any of these crypto products and fiat accounts as well, using any of the channels currently available such as internet banking, mobile banking, phone banking and ATMs. Allow them to withdraw funds from their crypto accounts (turned into fiat) at any branch of the bank or ATM network.

* Implement an architecture that embraces the evolution of the underlying technologies in order to help them get quickly on top of it with new products and services for their customers and adapt easily to any future change. Assume there will be multiple public networks for transporting value and design the banking com.bitdubai.platform in a way that it is capable of quickly adapting to the requirements posed by any of these .

* Enable traditional banks to run a crypto bank independent from third party service providers thereby avoiding the risk associated with having to rely on startups that may not comply with regulations or go bankrupt overnight. 

##### Associated Concepts:

* Crypto Banking Platform
* Digital Vault
* Money Stream
* Pocket Money
* Bank Segments Wallet
* Smart Sourcing of Funds.

##### Associated Functionality:

* Crypto products in current core banking systems
* Crypto account system
* Refill engine which monitors banks' customers' wallet and automatically refills them



## Problem #5
### Almost nobody is marketing crypto currencies

#### Description:

Most recently a few well-funded startups have started spending money on marketing crypto currencies to the general public. Besides that regular people are still at the mercy of the mood of the mainstream media which is strongly influenced by the bitcoin price performance. The question is how to make every single business of a certain size all around the world spend their own financial resources on marketing crypto currencies to consumers and merchants alike and how to make them independent from both mainstream media coverage and the few resources startups have.

#### Solution:

* Give every single business around the world the possibility of re-branding one of the hundreds of segmented wallets in a fast and inexpensive way (basically for free).
* Allow them to easily affiliate with shops to accept their wallets and handle all the details of the different kinds of deals the branded wallet publisher could do with a shop. Ensure automatic enforcement of the contract between the wallet publisher and the shop accepting their branded wallet.
* Allow them to keep in touch with their user base by sending them any number of different tokens representing coupons, discounts, etc, or even an advertisement with some value attached. These tokens with crypto value attached can either be used as intended or traded by users at will or traded automatically by the com.bitdubai.platform's AI agent acting on behalf of the user.

##### Associated Concepts:

* Branded Wallet
* Wallet Publisher
* Wallet AI Agent


## Prototype

### Android APP proto

[Download the Android APP here](https://github.com/bitDubai/smart-wallet/blob/master/proto/app-debug.apk).

### Wallet Manager

![](https://github.com/bitDubai/smart-wallet/blob/master/proto/wallet_manager_1.png)

### Shop Manager

![](https://github.com/bitDubai/smart-wallet/blob/master/proto/shop_manager_1.png)

### Wallet Store

![](https://github.com/bitDubai/smart-wallet/blob/master/proto/wallet_store_1.png)
![](https://github.com/bitDubai/smart-wallet/blob/master/proto/wallet_store_2.png)
![](https://github.com/bitDubai/smart-wallet/blob/master/proto/wallet_store_3.png)
![](https://github.com/bitDubai/smart-wallet/blob/master/proto/wallet_store_4.png)

### Kids Wallet 

![](https://github.com/bitDubai/smart-wallet/blob/master/proto/wallet_kids_1.png)
![](https://github.com/bitDubai/smart-wallet/blob/master/proto/wallet_kids_2.png)
![](https://github.com/bitDubai/smart-wallet/blob/master/proto/wallet_kids_3.png)
![](https://github.com/bitDubai/smart-wallet/blob/master/proto/wallet_kids_4.png)

### Ladies Wallet 

![](https://github.com/bitDubai/smart-wallet/blob/master/proto/wallet_teens_1.png)
![](https://github.com/bitDubai/smart-wallet/blob/master/proto/wallet_teens_2.png)
![](https://github.com/bitDubai/smart-wallet/blob/master/proto/wallet_teens_3.png)
![](https://github.com/bitDubai/smart-wallet/blob/master/proto/wallet_teens_4.png)
![](https://github.com/bitDubai/smart-wallet/blob/master/proto/wallet_teens_5.png)
![](https://github.com/bitDubai/smart-wallet/blob/master/proto/wallet_teens_6.png)
![](https://github.com/bitDubai/smart-wallet/blob/master/proto/wallet_teens_7.png)
![](https://github.com/bitDubai/smart-wallet/blob/master/proto/wallet_teens_8.png)
![](https://github.com/bitDubai/smart-wallet/blob/master/proto/wallet_teens_9.png)
![](https://github.com/bitDubai/smart-wallet/blob/master/proto/wallet_teens_10.png)
![](https://github.com/bitDubai/smart-wallet/blob/master/proto/wallet_teens_11.png)
![](https://github.com/bitDubai/smart-wallet/blob/master/proto/wallet_teens_12.png)





