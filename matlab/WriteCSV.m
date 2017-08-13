function WriteCSV(filename, array)
%WRITECSV Save given cell array to CSV file
%   WRITECSV(ARRAY) Input array to write to CSV file
%
%13 August 2017, Benjamin Shanahan.

% Error check inputs
if ~iscell(array)
    error('Function input must be cell array');
end

[nRows, nCols] = size(array);

% Write to file
fid = fopen(filename,'a');
for row = 1:nRows
    for col = 1:nCols
        fprintf(fid, SmartPrintf(array{row,col}));
        if col < nCols  % add comma except in last column
            fprintf(fid, ',');
        else  % add newline
            fprintf(fid, '\r\n');
        end
    end
end
fclose(fid);

    function s = SmartPrintf(val)
        %SMARTPRINTF Print value (thing) intelligently
        if ischar(val)
            s = sprintf('%s', val);
        else  % must be a number, I guess
            s = sprintf('%.08f', val);
        end
    end

end