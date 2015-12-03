package com.omn.mpfactory.hibernate.state;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.CollectionUtils;

import com.omn.mpfactory.hibernate.state.StateServiceImpl;
import com.omn.mpfactory.model.State;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:ApplicationContext-hibernate.xml" })
public class StateServiceImplTest {

	private static Log LOG = LogFactory.getLog(StateServiceImplTest.class);

	private static final Integer NR_OF_STATES = 16;
	private static final Long ID_TO_TEST = -1L;

	@Autowired
	StateServiceImpl stateService;

	@Test
	public void testFindAll() {
		List<State> stateList=stateService.findAll();
		Assert.assertFalse("State list should not be empty", CollectionUtils.isEmpty(stateList));
		Assert.assertEquals("Number of states is not correct.", NR_OF_STATES, new Integer(stateList.size()));
	}

	@Test
	public void testCRUD() {
		State state = stateService.findById(ID_TO_TEST);
		if(null==state){
			state=getState(ID_TO_TEST);
			stateService.create(state);
		}else{
			LOG.error(String.format("Test state with id=[%s] will be deleted. This record should not exist.", ID_TO_TEST));
		}
		state = stateService.findById(ID_TO_TEST);
		Assert.assertNotNull("State should not be null.", state);
		String newName = state.getName()+"_additional_sufix";
		state.setName(newName);
		stateService.update(state);
		State stateTwo = stateService.findById(ID_TO_TEST);
		Assert.assertEquals("Name should be equal.", stateTwo.getName(), newName);
		
		//delete test record
		stateService.delete(state);
		state = stateService.findById(ID_TO_TEST);
        Assert.assertNull(String.format("Record with id=[%s] should not exist", ID_TO_TEST), state);
	}
	
	private State getState(Long id){
		State state = new State();
		state.setId(id);
		state.setName("TestState");
		return state;
	}
}
