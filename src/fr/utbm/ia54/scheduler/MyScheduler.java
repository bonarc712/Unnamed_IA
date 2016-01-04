package fr.utbm.ia54.scheduler;

import fr.utbm.ia54.consts.Const;
import madkit.kernel.AbstractAgent;
import madkit.kernel.Scheduler;
import madkit.kernel.Scheduler.SimulationState;
import madkit.simulation.activator.GenericBehaviorActivator;


public class MyScheduler extends Scheduler {

	protected GenericBehaviorActivator<AbstractAgent> env;
	protected GenericBehaviorActivator<AbstractAgent> trains;
	protected GenericBehaviorActivator<AbstractAgent> cars;
	
	@Override
	protected void activate() {

		// 1 : request my role
		requestRole(Const.MY_COMMUNITY,
				Const.SIMU_GROUP,
				Const.SCH_ROLE); 
		
		// 3 : initialize the activators
		// by default, they are activated once each in the order they have been added
		env = new GenericBehaviorActivator<AbstractAgent>(Const.MY_COMMUNITY, Const.SIMU_GROUP, Const.ENV_ROLE, "doIt");
		trains = new GenericBehaviorActivator<AbstractAgent>(Const.MY_COMMUNITY, Const.SIMU_GROUP, Const.TRAIN_ROLE, "doIt");
		cars = new GenericBehaviorActivator<AbstractAgent>(Const.MY_COMMUNITY, Const.SIMU_GROUP, Const.CAR_ROLE, "doIt");
		
		addActivator(trains);
		addActivator(cars);
		addActivator(env);
		
		setDelay(35);

		//4 : let us start the simulation automatically
		setSimulationState(SimulationState.RUNNING);
	}
}
