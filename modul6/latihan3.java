public class latihan3 {

    private boolean ValidateRequest(CustomerInquiryRequest request, int customerIDFieldLength, int productFieldLength) {
        
        if (request.CustomerProduct.ProductNumber != null && request.Customer.CustomerID != null) {
            if (request.CustomerProduct.ProductNumber != string.Empty && request.Customer.CustomerID != string.Empty) {
                // Both were populated
                throw new BusinessException(HandleErrors.InvalidBothParameterMessage);
            
            } else if ((request.Customer.CustomerID == string.Empty) && (request.CustomerProduct.ProductNumber == string.Empty)) {
                // if objects were instantiated but not populated
                throw new BusinessException(HandleErrors.CustomerEmptyMessage);
            } else if (request.Customer.CustomerID != "") {
                // note : ProductNumber was equal
                // to string.empty check Customer ID length
                if (request.Customer.CustomerID.length > customerIDFieldLength) {
                    throw new BusinessException(HandleErrors.CustomerInvalidLengthMessage);
                }
            } else {
                // note : CustomerID was equal
                // to string.empty check Product Length
                if (request.CustomerProduct.ProductNumber.Length > productFieldLength) {
                    throw new BusinessException(HandleErrors.ProductInvalidLengthMessage);
                }
            }
        } else if (request.CustomerProduct.ProductNumber == null && request.Customer.CustomerID == null) {
            // Both were null
            throw new BusinessException(HandleErrors.CustomerEmptyMessage);
        } else if (request.CustomerProduct.ProductNumber == null) {
            // ProductNumber was null and CustomerID was not null
            if (request.Customer.CustomerID.Length > customerIDFieldLength) {
                throw new BusinessException(HandleErrors.CustomerInvalidLengthMessage);
            }

        } else { // ProductNumber not null and CustomerID was null
        // check product length
            if (request.CustomerProduct.ProductNumber.Length > productFieldLength) {
                throw new BusinessException(HandleErrors.ProductInvalidLengthMessage);
            }

        }
        // set objects below with formatted data i.e PadLeft
        if (request.Customer.CustomerID != null) {
            request.Customer.CustomerID = request.Customer.CustomerID.PadLeft(customerIDFieldLength,
            Convert.ToChar("0", CultureInfo.CurrentCulture));
        }
        if (request.CustomerProduct.ProductNumber != null) {
            request.CustomerProduct.ProductNumber = request.CustomerProduct.ProductNumber.PadLeft(productFieldLength,Convert.ToChar( "0",CultureInfo.CurrentCulture ) );
        }
        return true;
    }
}
