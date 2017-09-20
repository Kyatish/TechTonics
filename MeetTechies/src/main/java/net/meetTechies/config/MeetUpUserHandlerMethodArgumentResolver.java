/*package net.meetTechies.config;

import net.meetTechies.pojos.User;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class MeetUpUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver{
			 
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().equals(User.class)
        && parameter.getParameterAnnotation(RequestFormEncoded.class);
    }
 
    @Override
    public Object resolveArgument(MethodParameter methodParameter,
                                  ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest,
                                  WebDataBinderFactory webDataBinderFactory) throws Exception {
        userName: $scope.userName,
						//mobileNumber: $scope.mobileNumber,
						mobileNumber: parseInt($scope.mobileNumber,10),
						emailID: $scope.emailID,
						password: $scope.password,
						company: $scope.company,
						companyAddress:
					
    	System.out.println("In MeetUpUserHandlerMethodArgumentResolver ;rk;ekrop");
    	System.out.println(modelAndViewContainer.getView());
    	User returnUser = new User();
    	returnUser.setUserName(nativeWebRequest.getParameter("userName"));
    	returnUser.setEmailID(nativeWebRequest.getParameter("emailID"));
    	returnUser.setPassword(nativeWebRequest.getParameter("password"));
    	returnUser.setCompany(nativeWebRequest.getParameter("company"));
    	returnUser.setCompanyAddress(nativeWebRequest.getParameter("companyAddress"));
    	//System.out.println(nativeWebRequest.getParameter("mobileNumber"));
    	//returnUser.setMobileNumber(Long.parseLong(nativeWebRequest.getParameter("mobileNumber")));
    	returnUser.setMobileNumber(485895997);
        //String emailID = nativeWebRequest.getParameter("emailID");
        //String emailID = nativeWebRequest.getParameter("emailID");
 
        
        return returnUser;
        if (isNotSet(bar)) {
            bar = "defaultBar";
        }
 
        if (isNotSet(foo)) {
            foo = "defaultFoo";
        }
 
	        return new FooBar(bar, foo);
	    }
	 
	    
	}
    private boolean isNotSet(String value) {
        return value == null;
    }
}
*/