import kotlin.random.Random

fun main() {
    // Valores entre 0 e 50
    val billings = arrayOf(910, 207, 378, 376, 654, 66, 144, 856, 422, 65, 978, 326, 661, 422, 518, 619, 900, 46, 387, 425, 537, 342, 754, 627, 187, 813, 997, 356, 708, 501, 74, 604, 23, 862, 321, 262, 869, 653, 651, 629, 252, 266, 758, 944, 148, 782, 615, 817, 60, 326, 263, 494, 348, 409, 519, 499, 417, 374, 251, 463, 694, 855, 555, 194, 305, 534, 410, 634, 101, 806, 668, 800, 154, 87, 291, 678, 907, 690, 164, 535, 406, 844, 432, 724, 545, 201, 76, 768, 329, 389, 768, 985, 809, 441, 735, 87, 211, 408, 9, 35, 283, 767, 262, 625, 466, 987, 538, 828, 385, 857, 466, 620, 358, 772, 687, 962, 19, 507, 793, 242, 236, 432, 462, 17, 141, 817, 524, 871, 348, 112, 974, 365, 980, 203, 722, 678, 820, 241, 173, 184, 57, 165, 600, 969, 700, 627, 187, 590, 700, 132, 115, 793, 927, 344, 258, 583, 160, 735, 194, 70, 529, 402, 734, 949, 867, 90, 152, 405, 981, 501, 714, 927, 760, 331, 1, 219, 919, 655, 466, 386, 537, 915, 890, 800, 287, 648, 544, 405, 250, 585, 782, 504, 264, 547, 647, 892, 578, 259, 932, 372, 583, 972, 254, 177, 420, 306, 603, 886, 267, 132, 449, 179, 316, 804, 151, 260, 528, 820, 905, 889, 17, 420, 164, 778, 282, 679, 56, 183, 800, 258, 500, 590, 165, 391, 833, 366, 343, 538, 125, 119, 102, 448, 987, 392, 354, 56, 560, 972, 554, 437, 226, 167, 12, 131, 833, 886, 588, 565, 188, 818, 912, 438, 209, 125, 235, 944, 379, 501, 927, 738, 921, 783, 641, 831, 994, 975, 228, 681, 514, 350, 485, 271, 100, 246, 2, 798, 189, 940, 252, 972, 496, 559, 762, 401, 801, 500, 130, 578, 252, 707, 681, 75, 48, 266, 15, 122, 657, 541, 952, 142, 70, 364, 224, 988, 385, 699, 460, 709, 399, 152, 916, 740, 5, 306, 932, 584, 7, 731, 379, 259, 921, 823, 755, 510, 898, 765, 377, 276, 562, 454, 593, 551, 999, 688, 306, 659, 721, 861, 288, 934, 854, 668, 254, 933, 929, 790, 269, 222, 481, 440, 414, 463, 366, 457, 179, 705,)

    // Por não ser um requisito utilizar pouca memória o MergeSort se torna uma boa opção por ser sempre
    // O(n * log n), fazendo com que seja extremamente efetivo nesse caso
    mergeSort(billings)

    val minBill = billings.first()
    val maxBill = billings.last()
    val medBill = billings.filter { it != 0 }.average()

    val x = billings.count { it > medBill }

    println("""
Faturamento Minimo: $minBill
Faturamento Máximo: $maxBill
Média Anual: $medBill
Quantidade de dias em que o faturamento foi maior que média anual: $x
    """.trimIndent())




}

fun mergeSort(billings: Array<Int>, left: Int = 0, right: Int = billings.size - 1) {
    if (left >= right)
        return

    val middle = (left + right) / 2
    mergeSort(billings, left, middle)
    mergeSort(billings, middle + 1, right)

    merge(billings, left, middle, right)
}

fun merge(billings: Array<Int>, left: Int, middle: Int, right: Int) {
    val aux = arrayOf(*billings)

    var i = left
    var j = middle + 1
    var k = left

    while(i <= middle && j <= right) {
        if(aux[i] <= aux[j]) {
            billings[k] = aux[i]
            i++
        } else {
            billings[k] = aux[j]
            j++
        }
        k++
    }

    while(i <= middle) {
        billings[k] = aux[i]
        i++
        k++
    }
}

