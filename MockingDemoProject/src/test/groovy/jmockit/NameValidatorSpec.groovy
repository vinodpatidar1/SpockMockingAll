package jmockit

import mockit.Deencapsulation
import mockit.Mock
import mockit.MockUp
import spock.lang.Shared
import spock.lang.Specification

/**
 * @author mumtazbanur
 */
class NameValidatorSpec extends Specification{

	def nameValidator =new NameValidator()
	
	@Shared MockUp<NameValidator> mockNameValidator
	
	def setupSpec() {
		mockNameValidator = new MockUp<NameValidator>() {
			//Mock Constructor 
			@Mock void $init() {
			}
			//Mock static block
			@Mock void $clinit() {
			}
		}
	}
	
	def'API to test for max length'(){
		given:'Mocked MAX_LENGTH final field for NameValidator'
			Deencapsulation.setField(NameValidator, "MAX_LENGTH", 20)
		when:'NameValidator.getMaxLength is called'
			def result = nameValidator.getMaxLength()
		then:'It should return mocked value for MAX_LENGTH'
			result == 20
	}
	
	def'API to get default name'(){
		given:'Set default_name for NameValidator'
			Deencapsulation.setField(nameValidator, "DEFAULT_NAME", "Gradle")
		when:'NameValidator.getDefaultName is called'
			def result = nameValidator.getDefaultName()
		then:'It should return default set name'
			result == 'Gradle'
	}
	
	def cleanupSpec() {
		mockNameValidator?.tearDown()
	}
}
