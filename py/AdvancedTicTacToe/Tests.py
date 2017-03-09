import main
import unittest

class TestSumEqualsProduct(unittest.TestCase):

    def test_fits_segmentIsOne(self):
        width = 5
        segment = 1
        expected = 5
        answer = main.fits(width, segment)
        self.assertEqual(answer, expected)

    def test_fits_segmentIsLonger(self):
        width = 3
        segment = 4
        expected = 0
        answer = main.fits(width, segment)
        self.assertEqual(answer, expected)

    def test_fits_sameLength(self):
        width = 3
        segment = 3
        expected = 1
        answer = main.fits(width, segment)
        self.assertEqual(answer, expected)

    def test_fits_segmentIsHalfLength(self):
        width = 6
        segment = 3
        expected = 4
        answer = main.fits(width, segment)
        self.assertEqual(answer, expected)

    def test_fits_lessThenHalf(self):
        width = 5
        segment = 2
        expected = 4
        answer = main.fits(width, segment)
        self.assertEqual(answer, expected)


    def test_sqaureFits_SquareIsOne(self):
        totalHeight = 4
        totalWidth = 4
        segmentHeight = 2
        segmentWidth = 2
        expected = 9
        answer = main.squareFits(totalHeight, totalWidth, segmentHeight, segmentWidth)
        self.assertEqual(answer, expected)

    def test_sqaureFits_halfLength(self):
        totalHeight = 4
        totalWidth = 4
        segmentHeight = 2
        segmentWidth = 2
        expected = 9
        answer = main.squareFits(totalHeight, totalWidth, segmentHeight, segmentWidth)
        self.assertEqual(answer, expected)

    def test_1(self):
        r = 3
        c = 3
        k = 3
        expected = 8
        answer = main.count(r, c, k)
        self.assertEqual(answer, expected)


    def test_2(self):
        r = 3
        c = 3
        k = 2
        expected = 20
        answer = main.count(r, c, k)
        self.assertEqual(answer, expected)

    def test_3(self):
        r = 3
        c = 4
        k = 1
        expected = 12
        answer = main.count(r, c, k)
        self.assertEqual(answer, expected)

    def test_4(self):
        r = 1
        c = 5
        k = 5
        expected = 1
        answer = main.count(r, c, k)
        self.assertEqual(answer, expected)

    def test_5(self):
        r = 1
        c = 5
        k = 3
        expected = 3
        answer = main.count(r, c, k)
        self.assertEqual(answer, expected)

    def test_6(self):
        r = 5
        c = 1
        k = 5
        expected = 1
        answer = main.count(r, c, k)
        self.assertEqual(answer, expected)

    def test_7(self):
        r = 5
        c = 1
        k = 3
        expected = 3
        answer = main.count(r, c, k)
        self.assertEqual(answer, expected)

    def test_8(self):
        r = 3
        c = 4
        k = 5
        expected = 0
        answer = main.count(r, c, k)
        self.assertEqual(answer, expected)

    def test_9(self):
        r = 12
        c = 10
        k = 8
        expected = 116
        answer = main.count(r, c, k)
        self.assertEqual(answer, expected)

    def test_10(self):
        r = 97
        c = 83
        k = 5
        expected = 30076
        answer = main.count(r, c, k)
        self.assertEqual(answer, expected)

if __name__ == '__main__':
    unittest.main()
