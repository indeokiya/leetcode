class Solution {
    func setZeroes(_ matrix: inout [[Int]]) {
        let m:Int = matrix.count
        let n:Int = matrix[0].count
        var flag:Bool = false
        
        for i in 0..<m {
            if matrix[i][0] == 0 {
                flag = true
            }
            
            for j in 1..<n {
                if matrix[i][j] == 0 {
                    matrix[0][j] = 0
                    matrix[i][0] = 0
                }
            }
        }
        
        for j in 1..<n {
            if matrix[0][j] == 0 {
                for i in 1..<m {
                    matrix[i][j] = 0
                }
            }
        }

        for i in 0..<m {
            if matrix[i][0] == 0 {
                for j in 1..<n {
                    matrix[i][j] = 0
                }
            }
        }
    
        if flag {
            for i in 0..<m {
                matrix[i][0] = 0
            }
        }
    }
}