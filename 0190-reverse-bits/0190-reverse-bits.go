func reverseBits(num uint32) uint32 {
    answer := uint32(0)
    mask1, mask2 := uint32(0x1<<31), uint32(0x1)
    
    for i:=0; i<32; i++ {
        if mask2 & num > 0 {
            answer |= mask1    
        }
        
        mask1 >>= 1
        mask2 <<= 1
    }
    
    
    
    return answer
}