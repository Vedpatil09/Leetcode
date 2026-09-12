class Spreadsheet {

    private int[][] sheet;

    public Spreadsheet(int rows) {
        sheet = new int[rows][26];
    }

    public void setCell(String cell, int value) {

        int row = getRow(cell);
        int col = getCol(cell);

        sheet[row][col] = value;
    }

    public void resetCell(String cell) {

        int row = getRow(cell);
        int col = getCol(cell);

        sheet[row][col] = 0;
    }

    public int getValue(String formula) {

        // Remove '='
        formula = formula.substring(1);

        // Split into two operands
        String[] parts = formula.split("\\+");

        return getOperandValue(parts[0])
             + getOperandValue(parts[1]);
    }

    private int getOperandValue(String operand) {

        // If operand is a number
        if (Character.isDigit(operand.charAt(0))) {
            return Integer.parseInt(operand);
        }

        // Otherwise operand is a cell
        int row = getRow(operand);
        int col = getCol(operand);

        return sheet[row][col];
    }

    private int getRow(String cell) {

        return Integer.parseInt(
            cell.substring(1)
        ) - 1;
    }

    private int getCol(String cell) {

        return cell.charAt(0) - 'A';
    }
}