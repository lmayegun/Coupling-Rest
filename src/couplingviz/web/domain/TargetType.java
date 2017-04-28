package couplingviz.web.domain;

import org.springframework.stereotype.Component;

/**
 *  A POJO class annotated as a component and has fields of only boolean types. The 
 *  class states the type/s of coupling/s a class or an interface in a source code has.
 * @version 1.0, April 2017
 */
@Component
public class TargetType {
	
	private boolean isDirectTarget;
	private boolean isLocalInheritanceTarget;
	private boolean isForeignInheritanceTarget;
	private boolean isInterfaceTarget;
	
	public TargetType(){
		
	}

	
	public boolean isIsDirectTarget() {
		return isDirectTarget;
	}
	public void setIsDirectTarget(boolean isdirectTarget) {
		isDirectTarget = isdirectTarget;
	}
	public boolean isIsLocalInheritanceTarget() {
		return isLocalInheritanceTarget;
	}
	public void setIsLocalInheritanceTarget(boolean islocalInheritanceTarget) {
		isLocalInheritanceTarget = islocalInheritanceTarget;
	}
	public boolean isIsForeignInheritanceTarget() {
		return isForeignInheritanceTarget;
	}
	public void setIsForeignInheritanceTarget(boolean isforeignInheritanceTarget) {
		isForeignInheritanceTarget = isforeignInheritanceTarget;
	}
	
	public boolean isIsInterfaceTarget() {
		return isInterfaceTarget;
	}
	public void setIsInterfaceTarget(boolean isinterfaceTarget) {
		isInterfaceTarget = isinterfaceTarget;
	}
}
