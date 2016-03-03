https://code.google.com/p/android/issues/detail?id=202400

Android data binding expression gets evaluated to the wrong value if, seemingly, the following conditions are met:
 1. It is a compound expression where one of the subexpressions contains a variable that is a field or method of an object.
 2. That exact subexpression is used elsewhere in a different data binding expression within the same layout.
 3. A variable in a different subexpression within the same expression gets rebound.
