package jmockit

import mockit.Deencapsulation
import mockit.Mock;
import mockit.MockUp;
import spock.lang.Shared
import spock.lang.Specification

/**
 * @author mumtazbanur
 */
class PersonSpec extends Specification {

	Person person = new Person()

	Allocator allocator

	MockUp<NameValidator> mockNameValidator
	MockUp<Allocator> mockAllocator
	
	public void mockIsNameValid() {
		mockNameValidator = new MockUp<NameValidator>() {
			@Mock
			Boolean isNameValid(String name) {
				return true;
			}
		}
	}

	public void mockGetAllocation(String value) {
		mockAllocator = new MockUp<Allocator>() {
			@Mock
			String getAllocation(String name) {
				return name.equalsIgnoreCase('jmockit')?value:'Not allocated'
			}
		}
	}

	def'API to test seting Name of person'(){
		given:'Mocked NameValidator isNameValid function'
			mockIsNameValid()
		when:'Person.setName is called'
			def result = person.setName('123')
		then:'It should return name for person'
			result == '123'
		cleanup:mockNameValidator?.tearDown()
	}
	
	def'API to test Details of person'(){ 
		given:'Mocked Allocator getAllocation function'
			mockGetAllocation(mockedVal)
		when:'Person.getDetails is called'
			def result = person.getDetails(name) 
		then:'It should return Not allocated message'
			result == exepectedResult
		cleanup:mockAllocator?.tearDown()
		where:
			name 		| mockedVal              || exepectedResult
			'jmockit'   | 'Jmockit is Allocated' || 'Jmockit is Allocated'
			'Spock'     | null					 || 'Not allocated' 
	}
}