public class hasilRefactoringL3{
    // method utama
    private void ValidateRequest(CustomerInquiryRequest request, int customerFieldLength, int productFieldLength){
        // 1. Check both parameters are not null and not empty strings
        CheckCustomerInquiryNotNullOrEmpty( request );
        // 2. Check both parameters aren't populated
        CheckCustomerInquiryNullOrEmpty( request );
        // 3. Check CustomerID for field length and pad the parameter
        CheckCustomerIDValid( request, customerFieldLength );
        // 4. Check ProductNumber for field length and pad the parameter
        CheckProductNumberValid( request, productFieldLength );
    }

    // method baru untuk mengecek apakah string input null atau string kosong
    private void CheckCustomerInquiryNotNullOrEmpty(CustomerInquiryRequest request){
        // Check both parameters are not null or empty string
        if( !string.IsNullOrEmpty( request.CustomerProduct.ProductNumber ) && !string.IsNullOrEmpty( request.Customer.CustomerID ) ) {
            // Both were populated
            throw new BusinessException(
            HandledErrors.InvalidBothParameterMessage );
        }
    }

    // method baru untuk menguji parameter
    private void CheckCustomerInquiryNullOrEmpty(CustomerInquiryRequest request ){
        if( string.IsNullOrEmpty( request.Customer.CustomerID ) && string.IsNullOrEmpty( request.CustomerProduct.ProductNumber ) ){
            // Both are null or empty string
            throw new BusinessException(HandledErrors.CustomerEmptyMessage);
        }
    }

    // method baru untuk menguji CustomerID
    private void CheckCustomerIDValid( CustomerInquiryRequest request, int customerIDFieldLength ){
        if( string.IsNullOrEmpty( request.Customer.CustomerID ) ){
            // Check Customer ID length
            if( request.Customer.CustomerID.Length > customerIDFieldLength ){
                throw new BusinessException(HandledErrors.CustomerInvalidLengthMessage );
            }
            // Pad the left of the customer id
            request.Customer.CustomerID = request.Customer.CustomerID.PadLeft(customerIDFieldLength, Convert.ToChar( "0", CultureInfo.CurrentCulture));
        }
    }

    // method baru untuk mengecek ProductNumber
    private void CheckProductNumberValid( CustomerInquiryRequest request,int productFieldLength ){
        if( string.IsNullOrEmpty( request.CustomerProduct.ProductNumber ) ){
            // Check Product Length
            if( request.CustomerProduct.ProductNumber.Length > productFieldLength ){
                throw new BusinessException(HandledErrors.ProductInvalidLengthMessage );
            }
            // Pad the left of the product number
            request.CustomerProduct.ProductNumber = request.CustomerProduct.ProductNumber.PadLeft(productFieldLength,Convert.ToChar( "0", CultureInfo.CurrentCulture ) );
        }
    }