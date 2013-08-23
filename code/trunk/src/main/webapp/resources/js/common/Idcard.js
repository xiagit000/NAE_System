function validateIdCard(card){
	var cardParrtern1=/^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$/; 
	//身份证正则表达式(18位) 
	var cardParrtern2=/^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/; 
	
	var isP1 = cardParrtern1.test(card);
	var isP2 = cardParrtern1.test(card);
	
	return (isP1 || isP2) ;
}