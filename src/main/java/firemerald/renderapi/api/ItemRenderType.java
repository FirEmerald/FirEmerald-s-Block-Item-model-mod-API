package firemerald.renderapi.api;

public enum ItemRenderType
{
	/** held item of other entities or 3rd person mode, right hand **/ 
	EQUIPPED_RIGHT,
	/** held item of other entities or 3rd person mode, left hand **/ 
	EQUIPPED_LEFT,
	/** held item in 1st person mode, right hand **/
	EQUIPPED_FIRST_PERSON_RIGHT,
	/** held item in 1st person mode, left hand **/
	EQUIPPED_FIRST_PERSON_LEFT,
	/** inventory **/
	GUI,
	/** item on the ground **/
	ENTITY,
	/** in head slot **/
	HEAD,
	/** on an item frame **/
	ITEMFRAME,
	/** couldn't be determined **/
	UNKNOWN
}