# pii-encrypt-demo
A Spring Boot based project that showcases the options to do columnar encryption of PII ( Personally Identifiable Information ) storage and look up. 

## Objectives
- Encrypt the PII fields in an entity automatically on db save and retrieve it as decrypted when reading from db. 
- Search the field without doing any manual encryption. 

## Components
- Spring boot ( 1.5.21 ) or later
- JPA 

## Steps
1. Define an `AttributeConverter` ( `PIIAttributeConverter`) that will convert the string to encrypted value during save to database and decrypt when reading from database.
2. Annotate the fields to be encrypted using `@Convert(converter = PIIAttributeConverter.class)`
3. The findByQueries and JQL queries will automatically apply the converter

# Notes
1. The attribute converter is auto applied for all the annotated field during saving and reading back. 
2. This is even applicable when we do look up and will convert the passed value to encrypted version and compare. 
3. Like keyword lookup won't work 
4. JQL queries ( `@Query` annotations) in repository also works without any additional code. 


# Classes
## PIIAttributeConverter.java
A Spring component that does the encryption and decryption of the attributes that are annoted. 
## Customer.java
The entity class holding PII data with PII fields annotated
## CustomerRespository.java
Standard repository class with necessary repo methods for retireval

# Resources
## Postman collections
- https://www.getpostman.com/collections/978217caca8f6e5f37b3
## MySQL queries 
```SQL 
 SELECT id,name,mobile,
 cast(aes_decrypt(from_base64(name),"secret-key-12345") as char) as 'Decrypted Name',
 cast(aes_decrypt(from_base64(mobile),"secret-key-12345") as char) as 'Decrypted Mobile' FROM `pii-encrypt-demo`.CUSTOMERS;
```
# TO DO ( IMPORTANT)
Make sure to take care of the below items before you implement this
1. Ensure that the secret key is not stored in the source code and instead take from a vault of secret storage config property. 