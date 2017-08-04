function indices = FindClosest(x, reference)
%FINDCLOSEST Find indices of closest values of x vector in reference vector
%
%3 August 2017, Benjamin Shanahan.

% Convert inputs to column vectors
x         = x(:);
reference = reference(:);

% Input vector x must be less than or equal to reference vector in length
if numel(x) > numel(reference)
    error('x must have same or fewer number of elements than reference');
end

% Transpose x vector to a row vector and then subtract it from reference so
% that we get a matrix of comparisons. Then find the index minimum absolute
% of the minimum value in each column.
[~,indices] = min(abs(reference - x'));