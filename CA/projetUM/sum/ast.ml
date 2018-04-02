type expr =
	| Add of expr * expr
	| Integer of int
	
type stmt =
	| Print of expr

