#const r = 3.
#const c = 4.

%
% coste matrix:
% 
%  50, 20,  120,   -50,
%  60, 20,   70,    60,
% -20,  0,  -40,   -60,
% 
%
coste(1,1,50).  coste(2,1,20). coste(3,1,120). coste(4,1,-50).
coste(1,2,60).  coste(2,2,20). coste(3,2,70).  coste(4,2,60).
coste(1,3,-20). coste(2,3,0).  coste(3,3,-40). coste(4,3,60).

% domains:
rows(1..r).
cols(1..c).

% 1: assigned, 0: not assigned
values(0..1).

%
% exacly one assignment per row, 
% all rows must be assigned
%
1 { x(Row, Col, 1) : cols(Col)  } 1 :- rows(Row).


% zero or one assignments per column
{ x(Row, Col, 1) : rows(Row) } 1 :- cols(Col).
% :- 2 { x(Row, Col, 1) : rows(Row) }, cols(Col).

% #minimize [ x(Row, Col, Val) : coste(Row, Col, Cost) = Val*Cost ].
% Must make rows and cols unique
#minimize { Cost,Row,Col: x(Row, Col, Val), coste(Row, Col, Cost)}.

total_cost(TotalCost) :- TotalCost = #sum{ Cost,Row,Col: x(Row, Col, Val), cost(Row, Col, Cost)}.

#show x/3.
#show total_cost/1.