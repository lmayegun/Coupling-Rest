package couplingviz.web.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *  A POJO class annotated as a component and represents the various attributes and properties 
 *  of a class or an interface in a source code. Its fields include also objects of the Coords
 *  and TargetType classes.
 * @version 1.0, April 2017
 */
@Component
public class Properties {
	
		private String name;
		private boolean isInterface;
		private boolean isTarget;
		private boolean isInnerclass;
		private int cBOCouplingViz;
		private int cBOTargetsOnly;
		private int cBONoInheritance;
		private int noOfDirectcalss;
		private int noOfCalssWithForeignInheritance;
		private int noOfCalssWithNativeInheritance;
		private int noOfInterfaces;
		private int noOfInterfaceDependencies;
		private int noOfInterfaceOrAbstract;
		private int noOfTotalCouples;
		private int couplingConstructors;
		private int noOfAncestorMethods;
		private int cBOWithAbstract;
		private String clr;
		private String reserveClr;
		private List<Coords> coords;
		private List<String> targets;	
		private HashMap<String, ArrayList<String>>  targetMethods = new HashMap();		
		private HashMap<String, TargetType>  targetTypes = new HashMap();
		
		
		public Properties(){
			
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public boolean isIsInterface() {
			return isInterface;
		}
		public void setIsInterface(boolean isinterfce) {
			isInterface = isinterfce;
		}
		public boolean isIsTarget() {
			return isTarget;
		}
		public void setIsTarget(boolean target) {
			isTarget = target;
		}
		
		public boolean isIsInnercalss() {
			return isInnerclass;
		}
		public void setIsInnercalss(boolean innercalss) {
			isInnerclass = innercalss;
		}
		public int getCBOCouplingViz() {
			return cBOCouplingViz;
		}
		public void setCBOCouplingViz(int cboCouplingViz) {
			cBOCouplingViz = cboCouplingViz;
		}
		public int getCBOTargetsOnly() {
			return cBOTargetsOnly;
		}
		public void setCBOTargetsOnly(int cboTargetsOnly) {
			cBOTargetsOnly = cboTargetsOnly;
		}
		public int getCBONoInheritance() {
			return cBONoInheritance;
		}
		public void setCBONoInheritance(int cboNoInheritance) {
			cBONoInheritance = cboNoInheritance;
		}
		public int getNoOfDirectcalss() {
			return noOfDirectcalss;
		}
		public void setNoOfDirectcalss(int noffDirectcalss) {
			noOfDirectcalss = noffDirectcalss;
		}
		public int getNoOfCalssWithForeignInheritance() {
			return noOfCalssWithForeignInheritance;
		}
		public void setNoOfCalssWithForeignInheritance(
				int noofCalssWithForeignInheritance) {
			noOfCalssWithForeignInheritance = noofCalssWithForeignInheritance;
		}
		public int getNoOfCalssWithNativeInheritance() {
			return noOfCalssWithNativeInheritance;
		}
		public void setNoOfCalssWithNativeInheritance(int noofCalssWithNativeInheritance) {
			noOfCalssWithNativeInheritance = noofCalssWithNativeInheritance;
		}
		public int getNoOfInterfaces() {
			return noOfInterfaces;
		}
		public void setNoOfInterfaces(int noofInterfaces) {
			noOfInterfaces = noofInterfaces;
		}
		public int getNoOfInterfaceDependencies() {
			return noOfInterfaceDependencies;
		}
		public void setNoOfInterfaceDependencies(int noofInterfaceDependencies) {
			noOfInterfaceDependencies = noofInterfaceDependencies;
		}
		public int getNoOfInterfaceOrAbstract() {
			return noOfInterfaceOrAbstract;
		}
		public void setNoOfInterfaceOrAbstract(int noofInterfaceOrAbstract) {
			noOfInterfaceOrAbstract = noofInterfaceOrAbstract;
		}
		public int getNoOfTotalCouples() {
			return noOfTotalCouples;
		}
		public void setNoOfTotalCouples(int noofTotalCouples) {
			noOfTotalCouples = noofTotalCouples;
		}
		public int getCouplingConstructors() {
			return couplingConstructors;
		}
		public void setCouplingConstructors(int couplingconstructors) {
			couplingConstructors = couplingconstructors;
		}
		public int getNoOfAncestorMethods() {
			return noOfAncestorMethods;
		}
		public void setNoOfAncestorMethods(int noofAncestorMethods) {
			noOfAncestorMethods = noofAncestorMethods;
		}
		public int getCBOWithAbstract() {
			return cBOWithAbstract;
		}
		public void setCBOWithAbstract(int cboWithAbstract) {
			cBOWithAbstract = cboWithAbstract;
		}
		public String getClr() {
			return clr;
		}
		public void setClr(String clr) {
			this.clr = clr;
		}
		public String getReserveClr() {
			return reserveClr;
		}
		public void setReserveClr(String reserveClr) {
			this.reserveClr = reserveClr;
		}
		public List<Coords> getCoords() {
			return coords;
		}
		@Autowired
		public void setCoords(List<Coords> coords) {
			this.coords = coords;
		}
		public List<String> getTargets() {
			return targets;
		}
		public void setTargets(List<String> targets) {
			this.targets = targets;
		}

		public HashMap<String, ArrayList<String>> getTargetMethods() {
			return targetMethods;
		}
		public void setTargetMethods(HashMap<String, ArrayList<String>> targetMethods) {
			this.targetMethods = targetMethods;
		}
		
		public void addTargetMethods(String key, ArrayList<String> val){
			targetMethods.put(key, val);
		}
		
		public HashMap<String, TargetType> getTargetTypes() {
			return targetTypes;
		}
		
		public void setTargetTypes(HashMap<String, TargetType> targetTypes) {
			this.targetTypes = targetTypes;
		}
		
		public void addTargetTypes(String key, TargetType val){
			targetTypes.put(key, val);
		}	

}
