func reverseBits(num uint32) uint32 {
    answer, mask := uint32(0), uint32(1)
    for i:=0; i<32; i++ {
        answer <<= 1
        answer |= num & mask
        num >>= 1
    }
    
    return answer
}